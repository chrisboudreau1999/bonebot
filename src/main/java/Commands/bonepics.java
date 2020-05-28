//rest easy hewson <3

package Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.EmbedBuilder;

public class bonepics extends Command {

	public bonepics() {
		this.name = "bone";
		this.aliases = new String[] { "bonepics" };
		this.help = "gives you a random pic of bone";
	}

	@Override
	protected void execute(CommandEvent event) {

		File file = new File("src/main/resources/bonepics.txt");
		Scanner input;
		try {
			input = new Scanner(file);
			ArrayList<String> boneList = new ArrayList<String>();
			String pic;
			while (input.hasNextLine()) {
				pic = input.nextLine();
				boneList.add(pic);
			}
			Random random = new Random();
			int number = random.nextInt(boneList.size());
			EmbedBuilder eb = new EmbedBuilder();
			eb.setImage(boneList.get(number));
			number++;
			event.getChannel().sendMessage(eb.build()).queue();
			event.getChannel().sendMessage(" " + event.getAuthor().getAsMention() + " congrats you got Bone pic #"
					+ number + " out of " + boneList.size()).queue();
		} catch (FileNotFoundException e) {
			event.getChannel().sendMessage("didnt work bro").queue();
		}

	}

}
