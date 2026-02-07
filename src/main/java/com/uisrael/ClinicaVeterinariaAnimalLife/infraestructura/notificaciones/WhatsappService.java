package com.uisrael.ClinicaVeterinariaAnimalLife.infraestructura.notificaciones;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;

@Service
public class WhatsappService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String fromNumber;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

    public void enviarMensaje(String telefonoDestino, String mensajeTexto) {
        try {
            
            String telf = telefonoDestino.trim();

            if (telf.startsWith("0")) {
                telf = "+593" + telf.substring(1);
            } 
            // Si por alguna razón no empieza con '+' ni con '0', le ponemos el '+'
            else if (!telf.startsWith("+")) {
                telf = "+" + telf;
            }

            String destinoFinal = "whatsapp:" + telf;
            
            Message.creator(
                new PhoneNumber(destinoFinal),
                new PhoneNumber(fromNumber),
                mensajeTexto
            ).create();

            System.out.println("✅ Mensaje enviado exitosamente a: " + destinoFinal);

        } catch (Exception e) {
            System.err.println("❌ Error enviando WhatsApp: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}