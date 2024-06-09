import gregtech.api.unification.material.event.MaterialEvent
import gregtech.api.unification.material.Material
import gregtech.api.items.metaitem.*
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import net.minecraft.util.ResourceLocation

import static gregtech.api.unification.material.info.MaterialFlags.*
import classes.MetaTileEntities

event_manager.listen { MaterialEvent event ->
    new Material.Builder(32000, resource('gcp', 'fluix'))
            .gem()
            .color(0x674FAF).iconSet('CERTUS')
            .flags('generate_plate', 'disable_decomposition', 'no_smelting', 'crystallizable')
            .components(material('certus_quartz'), material('nether_quartz'), material('redstone'))
            .build()

    new Material.Builder(32011, resource('gcp', 'mud'))
                .liquid()
                .color(0x211b14)
                .build()

    material('certus_quartz').addFlags('generate_rod', 'generate_bolt_screw')
    material('nether_quartz').addFlags('generate_rod', 'generate_bolt_screw')
    material('iron').addFlags('generate_dense')
    material('brass').addFlags('generate_spring')

    StandardMetaItem customMetaItems = new StandardMetaItem((short)2)
    customMetaItems.setRegistryName("meta_item_2")

    customMetaItems.addItem(200, "ingotPigIron")
    customMetaItems.addItem(210, "ironSmallChunk")

    Lead.addFlags("generate_round")
    Aluminium.addFlags("generate_round")

    MetaTileEntities.init()
}
