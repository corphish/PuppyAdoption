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
            id = 0,
            name = "Poppy",
            breed = "Beagle",
            age = "6 months",
            imageURL = "https://i.pinimg.com/originals/f7/2e/31/f72e31a9a382678f511ba44318da8237.png",
            description = "Beagles are cute.",
        ),
        Puppy(
            id = 1,
            name = "Jimmy",
            breed = "Samoyed",
            age = "1 year",
            imageURL = "https://thumbs.dreamstime.com/b/face-happy-samoyed-dog-36472428.jpg",
            description = "",
        ),
    )
}