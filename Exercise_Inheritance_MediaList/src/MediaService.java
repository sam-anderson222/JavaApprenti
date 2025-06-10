import java.util.ArrayList;

 class MediaService {
     private ArrayList<Media> mediaList;

     public MediaService() {
         mediaList = new ArrayList<>();
     }

     public void addMedia(Media media) {
         mediaList.add(media);
     }

     // Removes a piece of media with at a given index.
     public boolean removeMedia(int index) {
         try {
             mediaList.remove(index - 1); // Going from 1-based to 0-based.
             return true;
         } catch (IndexOutOfBoundsException ex) {
             return false;
         }
     }

     // Attempts to find a certain media by index, returns null if not found.
     // Replaced finding by name with index. Index is also 1-based, so it will have to shifted back to 0-based.
     public Media findMediaByIndex(int index) {
         try {
             return mediaList.get(index - 1); // Shift from 1-based to 0-based
         } catch (IndexOutOfBoundsException ex) {
             return null;
         }
     }

     // Returns a copy of the mediaList.
     public ArrayList<Media> getAllMedia() {
         return new ArrayList<>(mediaList);
     }

     // Returns the number of item in the mediaList array.
     public int getMediaCount() {
         return mediaList.size();
     }

     // Returns a boolean telling if the mediaList array is empty.
     public boolean isEmpty() {
         return mediaList.isEmpty();
     }




}
