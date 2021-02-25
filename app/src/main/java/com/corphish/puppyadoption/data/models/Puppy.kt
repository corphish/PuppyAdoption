package com.corphish.puppyadoption.data.models

/**
 * Data class to denote a puppy.
 */
data class Puppy(
    /**
     * Direct URL link to the image of this puppy.
     */
    val imageURL: String,

    /**
     * Name of the puppy.
     */
    val name: String,

    /**
     * Breed of the puppy.
     */
    val breed: String,

    /**
     * Description of the puppy.
     */
    val description: String,
)
