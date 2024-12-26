package AdapterPattern;

public class MusicPlayerAdapter implements USBDevice{

    //Why is IntelliJ saying that this variable could be final
    //Is this because the name of Music player could be final?
    private final OldMusicPlayer oldMusicPlayer;

    public MusicPlayerAdapter(OldMusicPlayer oldMusicPlayerUsingAdapter){
        oldMusicPlayer = oldMusicPlayerUsingAdapter;
    }

    @Override
    public void connectWithUSB() {
        oldMusicPlayer.playMusicUsingRCACable();
    }

}