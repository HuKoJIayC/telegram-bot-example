package com.github.hukojiayc.telegram.bot.example.command;

import com.github.hukojiayc.telegram.bot.handler.BaseCommand;
import com.github.hukojiayc.telegram.bot.utils.TelegramUtils;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Service
public class TestCommand extends BaseCommand {

  public TestCommand() {
    super("test", "test test");
  }

  @Override
  public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
    TelegramUtils.sendMessage(
        absSender,
        SendMessage.builder()
            .chatId(chat.getId().toString())
            .text("ТЕСТ!")
            .build()
    );
  }
}
