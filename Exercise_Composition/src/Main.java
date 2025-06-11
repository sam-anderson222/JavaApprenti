public class Main {
    public static void main(String[] args) {
        Artifact artifact = GetArtifactCommand.execute();

        IO.printArtifact(artifact);
        
    }
}
