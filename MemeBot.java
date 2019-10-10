package DiscordBot.FirstBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Random;

import DiscordBot.FirstBot.*;

public class MemeBot extends ListenerAdapter
{
	public void onMessageReceived(MessageReceivedEvent event)
    {    
		String message = event.getMessage().getContentRaw();
		
    	if(!event.getMember().getUser().isBot())
    	{
    		if(message.contains("Hi") || message.contains("Hello") || message.contains("hi") || message.contains("hello"))
    		{ 
    			event.getChannel().sendMessage("Hi, " + event.getMember().getUser().getName()).queue();
    		}
    		else if(message.contains("image"))
    		{
    			String result[] = message.split(" ");
    			EmbedBuilder eb = new EmbedBuilder();
    			String search = "";
        		try
        		{
        			for(int i = 1; i < result.length; i++)
        			{
        				search += result[i];
        			}
        			eb.setImage(findImage(search + "+meme"));
        		}
        		catch(IOException e)
        		{
        			System.out.println(e);
        		}
        		
        		event.getChannel().sendMessage(eb.build()).queue();
    		}
    		
    	}
    }
	
	public String findImage(String searchText) throws IOException
	{
		String encoding = "UTF-8";
		
		Document google = Jsoup.connect("https://www.google.com/search?newwindow=1&tbm=isch&sxsrf=ACYBGNRhd6T2wt5As2LfClXfaISjMUcFsw%3A1570726971566"
							+ "&source=hp&biw=1920&bih=968&ei=O2SfXf6kIITQrgS0srboDQ&q=" +
							searchText +"&oq=" + searchText + "&gs_l=img.3..35i39l2j0l8.1804.2551..2796...0.0..0.77.506.8......0....1..gws-wiz-img.....10."
							+ ".35i362i39.dK_oTw71cW8&ved=0ahUKEwi-rrX5lZLlAhUEqIsKHTSZDd0Q4dUDCAY&uact=5")
							.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 YaBrowser/19.9.3.315 Yowser/2.5 Safari/537.36").get();

		Elements websiteLinks = google.select("div[jscontroller]").select("img[data-src]");
		Random rand = new Random();
		int random = rand.nextInt(79);
		String link = websiteLinks.get(random).attr("data-src");	
		return link;
	}
}


