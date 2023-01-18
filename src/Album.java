
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private  List<Songs> songsList;  // just a variable not allocated memory

    // 1
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songsList = new ArrayList<>(); // here allocated memory
        System.out.println("\nAlbum has been created for the artist of " + artist);
    }

    // 2 - all getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public List<Songs> getSongsList() {
        return songsList;
    }
    public void setSongsList(List<Songs> songsList) {
        this.songsList = songsList;
    }


    // 3 - eakhne aro attribute dite pari
    public void addSongToAlbum(String title, String artist, String genre, double duration){
        // first step;
        Songs s = new Songs(title, duration, artist, genre);

        // jei song ta add korbo seta age thekei add hoyeache kina check korchi.
        if(findSong(s.getTitle()) == true && findSongDuration(s.getDuration()) == true ) {
            System.out.println("This songs is already present in album: Song- " + s.getTitle() + ", Artist- " + s.getArtist() + ", duration- " + s.getDuration());
        } else{
            songsList.add(s);
            System.out.println("New song has been added.");
        }
        return;
    }
    // 4 - find song function to check if the song current song is already present in album or not
    // 4.1 - eai tate song er address diye search kore dekhchilam.
//    public boolean findSong(Songs song){
//        // Song class er modhye song ta ache ki na check hocche.
//        for(Songs s:songsList){
//            if(s.equals(song)){
//                return  true;
//            }
//        }
//        return false;
//    }
    // 4.2 - eakhen song title dhore check kora hocche.
    public boolean findSong(String title){
        for(Songs s:songsList){
            if (s.getTitle().toUpperCase().equals(title.toUpperCase()) ){
                return true;
            }
        }
        return false;
    }
    public boolean findSongDuration(double duration){
        for(Songs s:songsList){
            if (s.getDuration() == duration ){
                return true;

            }
        }
        return false;
    }

    // concept of polymorphism - this is a practical use of polymorphism
    // playlist that something you made, because artijit sing or sidhu mosse wala your favirate
    // nije theke kichu kora jete pare
    public void addToPlayListFromAlbum(String title, LinkedList<Songs> playList){
        // jodi song ta match kore
        if (findSong(title) == true){
            // jodi matched song ta songslist e thake tobei playlist e add hobe.

            for (Songs song:songsList){
                if (song.getTitle().equals(title) ){
                    playList.add(song);
                    System.out.println("Song has been added to your Playlist");
                    break;
                }
            }
        }else{
            System.out.println("Song is not present in the Album.");
        }
        return;
    }
    public void addToPlayListFromAlbumWithTrackNo(int trackNo, LinkedList<Songs> playList){
        int index = trackNo-1;
        if (index >= 0 && index <= songsList.size()){
            playList.add(songsList.get(index));
            System.out.println("\nYour track no successfully added.");
        } else{
            System.out.println("\nInvalid track no.");
        }
    }


    public void removeToPlayListFromAlbum(String title, LinkedList<Songs> playList){
        // jodi song ta match kore
        if (findSong(title) == true){
            // jodi matched song ta songslist e thake tobei playlist e add hobe.
            for (Songs song:songsList){
                if (song.getTitle().equals(title)){
                    playList.remove(song);
                    System.out.println("\nSong has been removed to your Playlist");
                    break;
                }
            }
        }else{
            System.out.println("\nSong already been removed.");
        }
        return;
    }

    public void removeToPlayListFromAlbumWithTrackNo(int trackNo, LinkedList<Songs> playList){
        int index = trackNo-1;
        if (index >= 0 && index <= songsList.size()){
            playList.remove(songsList.get(index));
            System.out.println();
            System.out.println("Your track no successfully removed.");
        } else{
            System.out.println();
            System.out.println("Invalid track no.");
        }
    }

    public void allSongList(){
        for (Songs s:songsList){
            System.out.println("Song: " + s.getTitle() + ", Artist: " + s.getArtist() + ", duration: " + s.getDuration());
        }
        return;
    }

    public void printAllPlaylistSong(LinkedList<Songs> playList){
        System.out.println("All songs int the playlist: ");
        for (Songs s :
                playList) {
            System.out.println("Song: " + s.getTitle() + ", Artist: " + s.getArtist() );
        }
    }

}
