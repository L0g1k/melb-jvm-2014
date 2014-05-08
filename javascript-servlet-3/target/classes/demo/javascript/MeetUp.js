function MeetUp(args) {
	this.organiser = args.organiser
	this.location = args.location;
}

MeetUp.prototype = {
		getInformation: function() {
			return this.organiser + ", held at " + this.location;
		}

		toHTML: function() {
			// Mustache and Meetup-Java-Client
		}

		
}