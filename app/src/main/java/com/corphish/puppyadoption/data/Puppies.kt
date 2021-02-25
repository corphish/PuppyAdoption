package com.corphish.puppyadoption.data

import com.corphish.puppyadoption.data.models.Puppy

/**
 * Repository for puppies.
 */
object Puppies {

    /**
     * Static list of all the puppies.
     */
    val LIST = listOf(
        Puppy(
            name = "Poppy",
            breed = "Beagle",
            imageURL = "https://i.pinimg.com/originals/f7/2e/31/f72e31a9a382678f511ba44318da8237.png",
            description = "Beagles are cute.",
        ),
        Puppy(
            name = "Jimmy",
            breed = "Samoyed",
            imageURL = "https://thumbs.dreamstime.com/b/face-happy-samoyed-dog-36472428.jpg",
            description = "",
        ),
    )
}