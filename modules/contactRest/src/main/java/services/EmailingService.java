package services;

import dtos.ContactDto;
import dtos.EmailDto;

public interface EmailingService {
    void envoyerEmail(EmailDto emailDto);
    void envoyerContact(ContactDto contactDto);

}
