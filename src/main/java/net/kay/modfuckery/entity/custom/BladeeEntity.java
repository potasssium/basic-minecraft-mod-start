package net.kay.modfuckery.entity.custom;

import java.util.logging.Level;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;


public class BladeeEntity extends Animal{
    public BladeeEntity(EntityType<? extends Animal> pEntityType, net.minecraft.world.level.Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }


     public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        } else {
            LivingEntity target = this.level().getNearestPlayer(this, this.getAttributeBaseValue(Attributes.FOLLOW_RANGE));
            if (target != null && target.isAlive() && !target.isSpectator()) {
                if (!this.alertAnimationState.isStarted()) {
                    this.alertAnimationState.start(this.tickCount);
                }
            }
        }
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
        .add(Attributes.MAX_HEALTH, 200)
        .add(Attributes.FOLLOW_RANGE, 24D)
        .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }


    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }
}
