import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent
import gregtech.api.util.GTTeleporter
import gregtech.api.util.TeleportHandler
import gregtech.common.items.MetaItems
import gregtechfoodoption.item.GTFOMetaItem

final String FIRST_SPAWN = "gcp.first_spawn"

event_manager.listen { PlayerLoggedInEvent event ->
    def player = event.player
    def playerData = player.getEntityData()
    def data = playerData.hasKey(EntityPlayer.PERSISTED_NBT_TAG) ? playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG) : new NBTTagCompound()

    if (!player.getEntityWorld().isRemote && !data.getBoolean(FIRST_SPAWN)) {
        data.setBoolean(FIRST_SPAWN, true)
        playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data)
        player.addItemStackToInventory(MetaItems.PROSPECTOR_LV.getChargedStack(100000))
    }

}

