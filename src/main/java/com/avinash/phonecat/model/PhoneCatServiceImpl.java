package com.avinash.phonecat.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PhoneCatServiceImpl implements PhoneCatService {
    @Override
    public List<PhoneCatModel> getPhoneCats() {
        PhoneCatModel phoneCat1 = new PhoneCatModel("Nexus S",
                "Fast just got faster with Nexus S.");
        PhoneCatModel phoneCat2 = new PhoneCatModel("Motorola XOOM™ with Wi-Fi",
                "The Next, Next Generation tablet.");
        PhoneCatModel phoneCat3 = new PhoneCatModel("MOTOROLA XOOM",
                "The Next, Next Generation tablet.");
        return Arrays.asList(phoneCat1, phoneCat2, phoneCat3);
    }
}
