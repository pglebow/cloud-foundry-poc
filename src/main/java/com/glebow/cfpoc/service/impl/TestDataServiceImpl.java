/**
 * 
 */
package com.glebow.cfpoc.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.glebow.cfpoc.domain.TestData;
import com.glebow.cfpoc.repository.TestDataRepository;
import com.glebow.cfpoc.service.TestDataService;
import com.google.common.collect.Sets;

/**
 * @author pglebow
 *
 */
@Service
@Slf4j
public class TestDataServiceImpl implements TestDataService {

    /** Template response */
    private static final String template = "Hello, %s!";

    /** Stateful counter */
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private TestDataRepository repo;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Default
     */
    public TestDataServiceImpl() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gap.corporate.test.service.TestDataService#getResponse(java.lang.
     * String)
     */
    @Override
    public TestData getResponse(String name) {
        TestData retVal = new TestData(counter.incrementAndGet(), String.format(template, name));

        repo.save(retVal);

        return retVal;
    }

    @Override
    public Set<TestData> getAll() {
        Set<TestData> retVal = null;
        List<TestData> l = repo.findAll();
        if (l != null && !l.isEmpty()) {
            retVal = Sets.newHashSet(l);
        }
        return retVal;
    }

    @Override
    public void email(Set<TestData> data, String recipient) {
        if (data != null && !data.isEmpty() && recipient != null && !recipient.isEmpty()) {
            String text = getEmailText(data);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Test email message");
            message.setText(text);
            message.setTo(recipient);
            message.setFrom(recipient);
            try {
                javaMailSender.send(message);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private String getEmailText(Set<TestData> data) {
        String retVal = null;
        if (data != null && !data.isEmpty()) {
            Iterator<TestData> iterator = data.iterator();
            StringBuilder b = new StringBuilder();
            while (iterator.hasNext()) {
                b.append(iterator.next().toString());
                if (iterator.hasNext()) {
                    b.append(System.lineSeparator());
                }
            }
            retVal = b.toString();
        }
        return retVal;
    }
}
