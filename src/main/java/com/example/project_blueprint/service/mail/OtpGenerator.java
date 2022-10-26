package com.example.project_blueprint.service.mail;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OtpGenerator {

    private static final Integer EXPIRE_MIN = 1;
    private LoadingCache<String, Integer> otpCache;
    private LoadingCache<String, String> otpCacheForEmployer;

    /**
     * Constructor configuration.
     */
    public OtpGenerator()
    {
        super();
        otpCache = CacheBuilder.newBuilder()
                .expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String s) throws Exception {
                        return 0;
                    }
                });
        otpCacheForEmployer = CacheBuilder.newBuilder()
                .expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "0";
                    }
                });
    }

    /**
     * Method for generating OTP and put it in cache.
     *
     * @param key - cache key
     * @return cache value (generated OTP number)
     */
    public Integer generateOTP(String key)
    {
        Random random = new Random();
        int OTP = random.nextInt(1000, 9999);
        otpCache.put(key, OTP);

        return OTP;
    }

    public String generateOTPForEmployer(String key)
    {
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        otpCacheForEmployer.put(key, generatedString);

        return generatedString;
    }

    /**
     * Method for getting OTP value by key.
     *
     * @param key - target key
     * @return OTP value
     */
    public Integer getOPTByKey(String key)
    {
        return otpCache.getIfPresent(key);
    }
    public String getOPTForEmpByKey(String key)
    {
        return otpCacheForEmployer.getIfPresent(key);
    }

    /**
     * Method for removing key from cache.
     *
     * @param key - target key
     */
    public void clearOTPFromCache(String key) {
        otpCache.invalidate(key);
    }
    public void clearOTPForEmpFromCache(String key) {
        otpCacheForEmployer.invalidate(key);
    }
}
