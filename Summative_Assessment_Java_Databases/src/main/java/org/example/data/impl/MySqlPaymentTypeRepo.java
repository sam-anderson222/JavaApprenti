package org.example.data.impl;

import org.example.data.PaymentTypeRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.model.PaymentType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class MySqlPaymentTypeRepo implements PaymentTypeRepo {
    @Override
    public List<PaymentType> getAll() throws InternalErrorException {
        return List.of();
    }
}
