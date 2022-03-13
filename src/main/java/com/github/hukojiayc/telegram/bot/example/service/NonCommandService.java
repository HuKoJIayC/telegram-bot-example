package com.github.hukojiayc.telegram.bot.example.service;

import com.github.hukojiayc.telegram.bot.handler.NonCommandHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Primary
@Service
public class NonCommandService implements NonCommandHandler {

  @SneakyThrows
  @Override
  public BotApiMethod<?> processingMessage(AbsSender absSender, Message message) {
    log.info("Received non command message {} from chat {}", message.getText(), message.getChatId());

    absSender.execute(
        SendMessage.builder()
            .chatId(message.getChatId().toString())
            .text("cool")
            .build()
    );

    return SendMessage.builder()
        .chatId(message.getChatId().toString())
        .text("Получено 123456789:\n" + message.getText())
        .build();
  }
}
