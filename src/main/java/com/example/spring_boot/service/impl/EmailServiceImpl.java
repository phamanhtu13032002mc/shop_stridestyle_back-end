package com.example.spring_boot.service.impl;

import com.example.spring_boot.entity.BillEntity;
import com.example.spring_boot.entity.CustomerEntity;
import com.example.spring_boot.entity.UserEntity;
import com.example.spring_boot.payload.request.BillRequest;
import com.example.spring_boot.payload.request.CustomerRequest;
import com.example.spring_boot.payload.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl {
    @Autowired
    JavaMailSender mailSender;
    public void sendCreateBill(CustomerEntity userRequest, BillEntity billEntity)
            throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@shopme.com", "Stride Style Shoes");
        helper.setTo(userRequest.getEmail());

        String subject = "Đã tạo đơn hàng!";

        String content = "<p>Xin chào <b>" + userRequest.getFullName() + "!</b></p>"
                + "<p>Đơn hàng của bạn đã được tạo!</p>"
                + "<p>Thông tin đơn hàng.</p>"
                + "<p>Mã đơn hàng: <b>" + billEntity.getId()+ "</b></p>"
                + "<br>"
                + "<p>Họ tên người nhận: <b>" + billEntity.getFullName() + "</b></p>"
                + "<p>Tổng giá trị đơn hàng: <b>" + billEntity.getDownTotal() + "</b></p>"
                + "<p>Địa chỉ nhận hàng: <b>" + billEntity.getAddress() + "</b></p>"
                + "<br>"
                + "<p><u>Mọi thắc mắc vui lòng liên hệ:</u> stridestyleshoes@gmail.com</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }
    public void sendCreateBill(CustomerRequest customerRequest)
            throws UnsupportedEncodingException, MessagingException {
        // Convert CustomerRequest to CustomerEntity if needed
        CustomerEntity customerEntity = convertToCustomerEntity(customerRequest);

        // Now you can use customerEntity in your existing logic
        // ...

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("contact@shopme.com", "Stride Style Shoes");
        helper.setTo(customerEntity.getEmail());

        String subject = "Đã tạo đơn hàng!";
        String content = "<p>Xin chào <b>" + customerEntity.getFullName() + "!</b></p>"
                + "<p>Đơn hàng của bạn đã được tạo!</p>"
                + "<p>Thông tin đơn hàng.</p>"
                + "<br>"
                + "<p>Họ tên người nhận: <b>" + customerEntity.getFullName() + "</b></p>"
                + "<p>Địa chỉ nhận hàng: <b>" + customerEntity.getAddress() + "</b></p>"
                + "<br>"
                + "<p><u>Mọi thắc mắc vui lòng liên hệ:</u> stridestyleshoes@gmail.com</p>";

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }

    private CustomerEntity convertToCustomerEntity(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail(customerRequest.getEmail());
        // Map other properties if needed
        customerEntity.setFullName(customerRequest.getFullName());
        customerEntity.setAddress(customerRequest.getAddress());
        // Map other properties if needed
        return customerEntity;
    }



}