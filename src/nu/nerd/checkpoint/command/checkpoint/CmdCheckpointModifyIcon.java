package nu.nerd.checkpoint.command.checkpoint;

import nu.nerd.checkpoint.Checkpoint;
import nu.nerd.checkpoint.CheckpointCourse;
import nu.nerd.checkpoint.CheckpointPlayer;
import nu.nerd.checkpoint.DescribableMeta;
import nu.nerd.checkpoint.command.CheckpointCommand;
import nu.nerd.checkpoint.exception.CheckpointException;
import nu.nerd.checkpoint.exception.UsageException;
import org.bukkit.inventory.ItemStack;

import java.util.Queue;

@DescribableMeta(
        name = "icon",
        description = "sets the icon to your currently held item",
        usage = "<label>"
)
public class CmdCheckpointModifyIcon extends CheckpointCommand {

    @Override
    public String execute(CheckpointPlayer player, Queue<String> args) throws CheckpointException {
        if (args.size() != 1) {
            throw new UsageException(this);
        }

        CheckpointCourse course = player.getCourse();
        String label = args.poll().toLowerCase();
        Checkpoint checkpoint = course.getCheckpoint(label);
        ItemStack icon = player.getHeldItem();

        checkpoint.setIcon(icon);

        return "Checkpoint {{" + label + "}} icon set to {{" + icon.getType().toString() + "}}.";
    }

}
