package DiscordBot.FirstBot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class App //extends ListenerAdapter
{
    public static void main( String[] args ) throws LoginException
    {
        JDABuilder builder = new JDABuilder(AccountType.BOT).setToken("NjMxOTI2MTUxMDE0NTE0NzM1.XZ99Ow.34q_OjCnVEsecXb5v8o8M4pKeLo");
        builder.addEventListeners(new MemeBot());

        builder.build();
    }
	
}

