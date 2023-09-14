package real.npc;

import real.player.Player;
import server.io.Message;

public class Menu {

    public int npcId;

    public String npcSay;

    public String[] menuSelect;

    public void openMenu(Player player) {
        Message msg = null;
        try {
            msg = new Message(32);
            msg.writer().writeShort(npcId);
            msg.writer().writeUTF(npcSay);
            msg.writer().writeByte(menuSelect.length);
            for (String menu : menuSelect) {
                msg.writer().writeUTF(menu);
            }
            player.sendMessage(msg);
        } catch (Exception e) {
        } finally {
            if (msg != null) {
                msg.cleanup();
                msg = null;
            }
        }
    }
}
