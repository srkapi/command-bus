package com.srkapi.shared.autoscan;

public interface BeanFactory {
  <R> R createBean(Class<R> beanClass);
}
