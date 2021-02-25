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
            imageURL = "",
            description = "",
        ),
        Puppy(
            name = "Jimmy",
            breed = "Spaniel",
            imageURL = "",
            description = "",
        ),
    )
}