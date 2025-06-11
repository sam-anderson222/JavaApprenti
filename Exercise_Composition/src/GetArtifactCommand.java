public class GetArtifactCommand {
    public static Artifact execute() {
        String artifactName = IO.getUserStr("Name of Artifact: ");
        int yearOfDiscovery = IO.getUserInt("Year of Discovery: ");

        String discovererFirstName = IO.getUserStr("First Name of Discoverer: ");
        String discovererLastName = IO.getUserStr("Last Name of Discoverer: ");
        String discovererSpeciality = IO.getUserStr("Speciality of Discoverer: ");
        Person discoverer = new Person(discovererFirstName, discovererLastName, discovererSpeciality);

        if (IO.getUserStr("Is the discoverer also the curator? (y/n): ").equalsIgnoreCase("N")) {
            String curatorFirstName = IO.getUserStr("First Name of Curator: ");
            String curatorLastName = IO.getUserStr("Last Name of Curator: ");
            String curatorSpeciality = IO.getUserStr("Speciality of Curator: ");
            Person curator = new Person(curatorFirstName, curatorLastName, curatorSpeciality);

            return new Artifact(artifactName, yearOfDiscovery, discoverer, curator);
        } else {
            return new Artifact(artifactName, yearOfDiscovery, discoverer, discoverer);
        }

    }
}
