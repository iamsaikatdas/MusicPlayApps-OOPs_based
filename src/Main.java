import java.util.*;

public class Main {
    public  static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        // Songs song = new Songs();
        Album album1 = new Album("Moosa Album", "Sidhu Moosewala");
        album1.addSongToAlbum("295", "Sidhu Moosewala", "Pop", 4.06);
        album1.addSongToAlbum("Last ride", "Sidhu Moosewala", "Sad", 5.06);
        album1.allSongList();


        Album album2 = new Album("Arijit's song", "Arijit Singh");
        album2.addSongToAlbum("O re priya", "Arijit Singh", "Sad", 4.6);
        album2.addSongToAlbum("Tum hi ho", "Arijit Singh", "Sad", 5.6 );
        album2.allSongList();

        albums.add(album1);
        albums.add(album2);

        LinkedList<Songs> myPlayList = new LinkedList<>();
        album1.addToPlayListFromAlbum("295", myPlayList);
        album1.addToPlayListFromAlbum("Last ride", myPlayList);
        album2.addToPlayListFromAlbum("Tum hi ho", myPlayList);
        album2.addToPlayListFromAlbumWithTrackNo(1, myPlayList);
        album2.printAllPlaylistSong(myPlayList);

        // (abc) reference to - songs
//        Songs song = new Songs("Kichu kotha bolo na priyo", 5.6, "Abhijit", "Romantic");
        // System.out.println(song);

        playSong(myPlayList);

    }
    public static void playSong(LinkedList<Songs> playList){
        ListIterator<Songs> itr = playList.listIterator();
        boolean isForwarded =false;

        // 1 - first song play korte gele akta gaan thakte hobe
        if (playList.size() > 0){
            System.out.print("Playing: ");
            System.out.println(itr.next());
            isForwarded = true;

        } else {
            System.out.println("Playlist is empty");
            return;
        }
        // 2 - option shows
        System.out.println("Select your choice: ");
        printMenu();


        // 3 -
        boolean quit = false;
        Scanner sc = new Scanner(System.in);
        while (!quit){
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    if(isForwarded == false){
                        itr.next();
                        isForwarded = true;
                    }
                    if (itr.hasNext()){
                        System.out.println(itr.next());
                    } else {
                        System.out.println("You have reached end of the playlist");
                        System.out.println("You doesn't move forwarded, because this is the last song of the playlist.");
                        isForwarded = false;
                    }
                    break;
                case 2:
                    if (isForwarded == true){
                        itr.previous();
                        isForwarded = false;
                    }
                    if (itr.hasPrevious()){
                        System.out.println(itr.previous());
                    } else {
                        System.out.println("You are the first of the playlist");
                        System.out.println("You doesn't move back, because this is the first song of the playlist.");
                        isForwarded = true;
                    }
                    break;
                case 3:
                    if (isForwarded == true){
                        if (itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForwarded =false;
                        }
                    } else {
                        if ((itr.hasNext())){
                            System.out.println(itr.next());
                            isForwarded = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    if (itr.hasNext()){
                        itr.remove();
                        System.out.println("Current song has been deleted.");
                    } else{
                        System.out.println("Last song in the playlist to delete, for delete song please playing previous song");
                    }
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }
    public static  void printSongs(LinkedList<Songs> myPlayList){
        for (Songs song : myPlayList)
            System.out.println(song);
        return;
    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu option");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Play all the song in playlist");
        System.out.println("7 - Exit");
        // aro kichu implement korte pari like - pause
    }

}