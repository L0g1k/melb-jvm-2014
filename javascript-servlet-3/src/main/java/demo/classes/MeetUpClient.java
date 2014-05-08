package demo.classes;

import java.util.List;

import meetup.ClientSettings;
import meetup.Group;
import meetup.GroupSearchCriteria;
import meetup.MeetupClient;
public class MeetUpClient {

	public static void main(String[] args) {

		   ClientSettings settings = new ClientSettings();
		   settings.setMeetupKey("77775e1779334c6d3d75263a406d4d5c");   

		   MeetupClient c = new MeetupClient();
		   c.setClientSettings(settings);
			
			
		   GroupSearchCriteria crit = new GroupSearchCriteria();
			
			crit.setTopic("Java");
			
			List<Group> groups = c.getGroups(crit);
			for (Group group : groups) {
				System.out.println(group.getName());
			}
	}
}
