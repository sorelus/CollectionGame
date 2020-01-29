package com.altima.validation.utilis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * class to help access to  messages.properties in code.
 * @author Sorelus Mkounga
 */
@Service
public class MessagesHelp {

    @Autowired
    private MessageSource messageSource;

    public String get(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}