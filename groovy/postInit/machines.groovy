import classes.globals
import classes.MetaTileEntityGreenhouse
import classes.MetaTileEntities
import classes.MetaTileEntityPrimitiveMudPump
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity

if (isReloading()) return

def circuits = [ore('circuitUlv'), ore('circuitLv'), ore('circuitMv'),
									ore('circuitHv'), ore('circuitEv'), ore('circuitIv'),
									ore('circuitLuv'), ore('circuitZpm'), ore('circuitUv')];

def conveyors = [null, metaitem('conveyor.module.lv'), metaitem('conveyor.module.mv'), metaitem('conveyor.module.hv'),
									 metaitem('conveyor.module.ev'), metaitem('conveyor.module.iv'), metaitem('conveyor.module.luv'),
									 metaitem('conveyor.module.zpm'), metaitem('conveyor.module.uv')];

def pumps = [null, metaitem('electric.pump.lv'), metaitem('electric.pump.mv'), metaitem('electric.pump.hv'),
								 metaitem('electric.pump.ev'), metaitem('electric.pump.iv'), metaitem('electric.pump.luv'),
								 metaitem('electric.pump.zpm'), metaitem('electric.pump.uv')];

/*def regulators = [null, metaitem('fluid.regulator.lv'), metaitem('fluid.regulator.mv'), metaitem('fluid.regulator.hv'),
		 metaitem('fluid.regulator.ev'), metaitem('fluid.regulator.iv'), metaitem('fluid.regulator.luv'),
		 metaitem('fluid.regulator.zpm'), metaitem('fluid.regulator.uv'), metaitem('fluid.regulator.uhv'),
		 metaitem('fluid.regulator.uev'), metaitem('fluid.regulator.uiv'), metaitem('fluid.regulator.uxv'),
		 metaitem('fluid.regulator.opv')];*/

def field_generators = [null, metaitem('field.generator.lv'), metaitem('field.generator.mv'), metaitem('field.generator.hv'),
										   metaitem('field.generator.ev'), metaitem('field.generator.iv'), metaitem('field.generator.luv'),
										   metaitem('field.generator.zpm'), metaitem('field.generator.uv')];

def emitters = [null, metaitem('emitter.lv'), metaitem('emitter.mv'), metaitem('emitter.hv'),
									metaitem('emitter.ev'), metaitem('emitter.iv'), metaitem('emitter.luv'),
									metaitem('emitter.zpm'), metaitem('emitter.uv')];

def sensors = [null, metaitem('sensor.lv'), metaitem('sensor.mv'), metaitem('sensor.hv'),
								   metaitem('sensor.ev'), metaitem('sensor.iv'), metaitem('sensor.luv'),
								   metaitem('sensor.zpm'), metaitem('sensor.uv')];

def motors = [null, metaitem('electric.motor.lv'), metaitem('electric.motor.mv'), metaitem('electric.motor.hv'),
								  metaitem('electric.motor.ev'), metaitem('electric.motor.iv'), metaitem('electric.motor.luv'),
								  metaitem('electric.motor.zpm'), metaitem('electric.motor.uv')];

def pistons = [null, metaitem('electric.piston.lv'), metaitem('electric.piston.mv'), metaitem('electric.piston.hv'),
								   metaitem('electric.piston.ev'), metaitem('electric.piston.iv'), metaitem('electric.piston.luv'),
								   metaitem('electric.piston.zpm'), metaitem('electric.piston.uv')];

def robotArms = [null, metaitem('robot.arm.lv'), metaitem('robot.arm.mv'), metaitem('robot.arm.hv'),
									 metaitem('robot.arm.ev'), metaitem('robot.arm.iv'), metaitem('robot.arm.luv'),
									 metaitem('robot.arm.zpm'), metaitem('robot.arm.uv')];

def hulls = [metaitem('hull.ulv'), metaitem('hull.lv'), metaitem('hull.mv'), metaitem('hull.hv'),
								 metaitem('hull.ev'), metaitem('hull.iv'), metaitem('hull.luv'),
								 metaitem('hull.zpm'), metaitem('hull.uv')];

def tieredWires = [ore('wireGtQuadrupleRedAlloy'), ore('wireGtQuadrupleCopper'), ore('wireGtQuadrupleCupronickel'), ore('wireGtQuadrupleKanthal'),
									   ore('wireGtQuadrupleNichrome'), ore('wireGtQuadrupleTungstenSteel'), ore('wireGtQuadrupleHssg'),
									   ore('wireGtQuadrupleNaquadah'), ore('wireGtQuadrupleNaquadahAlloy')];

def tieredPlates = [ore('plateWroughtIron'), ore('plateSteel'), ore('plateAluminium'), ore('plateStainlessSteel'),
										ore('plateTitanium'), ore('plateTungstenSteel'), ore('plateRhodiumPlatedPalladium'),
										ore('plateNaquadahAlloy'), ore('plateDarmstadtium')];

def tieredSticks = [ore('stickWroughtIron'), ore('stickIron'), ore('stickSteel'), ore('stickSteel'),
										ore('stickNeodymiumAlloy'), ore('stickVanadiumGallium'), ore('stickVanadiumGallium'),
										ore('stickVanadiumGallium'), ore('stickVanadiumGallium')];

def tieredGlass = [ore('blockGlass'), ore('blockGlass'), ore('blockGlass'), item('gregtech:transparent_casing:0'),
				   item('gregtech:transparent_casing:0'), item('gregtech:transparent_casing:2'), item('gregtech:transparent_casing:2'),
				   item('gregtech:transparent_casing:1'), item('gregtech:transparent_casing:1')];

def tieredCables = [ore('cableGtSingleRedAlloy'), ore('cableGtSingleTin'), ore('cableGtSingleCopper'), ore('cableGtSingleGold'),
										ore('cableGtSingleAluminium'), ore('cableGtSinglePlatinum'), ore('cableGtSingleNiobiumTitanium'),
										ore('cableGtSingleVanadiumGallium'), ore('cableGtSingleYttriumBariumCuprate')]

def tieredQuadCables = [ore('cableGtQuadrupleRedAlloy'), ore('cableGtQuadrupleTin'), ore('cableGtQuadrupleCopper'), ore('cableGtQuadrupleGold'),
					ore('cableGtQuadrupleAluminium'), ore('cableGtQuadruplePlatinum'), ore('cableGtQuadrupleNiobiumTitanium'),
					ore('cableGtQuadrupleVanadiumGallium'), ore('cableGtQuadrupleYttriumBariumCuprate')]

def tieredSprings = [metaitem('springIron'), metaitem('springCopper'), metaitem('springCupronickel'), metaitem('springKanthal'),
					 metaitem('springNichrome'), metaitem('springTungstenSteel'), metaitem('springHssg'),
					 metaitem('springNaquadah'), metaitem('springNaquadahAlloy')]


for (def i = 1; i < 9; i++) {
	crafting.addShaped("gregtech:weapons_factory." + i, metaitem('gcp:weapons_factory.' + globals.voltageTiers[i]), [
			[circuits[i], robotArms[i], circuits[i]],
			[conveyors[i], hulls[i], conveyors[i]],
			[tieredCables[i], circuits[i], tieredCables[i]]
	])
}

// MetaTileEntities.registerMetaTileEntity(32000, new MetaTileEntityGreenhouse(new ResourceLocation("gcp", "greenhouse")))

crafting.addShaped("gcp:primitive_mud_pump", metaitem('gcp:primitive_mud_pump'), [
		[metaitem('ringBronze'), metaitem('pipeNormalFluidTreatedWood'), metaitem('screwBronze')],
		[metaitem('rotorBronze'), item('gregtech:steam_casing'), ore('craftingToolScrewdriver')],
		[item('minecraft:stone_slab', 4), metaitem('pipeLargeFluidWood'), item('minecraft:stone_slab', 4)]
])




