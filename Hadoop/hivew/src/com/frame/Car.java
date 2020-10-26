package com.frame;

import org.springframework.stereotype.Service;

@Service
public interface Car<T> {
	public void status(T t);
}
