package com.corphish.puppyadoption.data

import com.corphish.puppyadoption.data.models.Puppy

/**
 * Repository for puppies.
 */
object Puppies {

    /**
     * Static list of all the puppies.
     * P.S - It will take a while for me to describe all the puppies.
     */
    val LIST = listOf(
        Puppy(
            id = 0,
            name = "Poppy",
            breed = "Beagle",
            age = "6 months",
            imageURL = "https://i.pinimg.com/originals/f7/2e/31/f72e31a9a382678f511ba44318da8237.png",
            description = "Hi hooman! I am sure that you have already fallen in love with me coz I am soo cute. I love hoomans too! I will love running and sniffing around your house \uD83D\uDE1C. P.S - Gib me loads of toys to chew \uD83D\uDE43.",
        ),
        Puppy(
            id = 1,
            name = "Jimmy",
            breed = "Samoyed",
            age = "8 months",
            imageURL = "https://worlddogfinder.com/upload/media/samoyed_smiling_muF1U2NDQ6.jpg",
            description = "",
        ),
        Puppy(
            id = 2,
            name = "Goldy",
            breed = "Golden Retriever",
            age = "1.1 years",
            imageURL = "https://thehappypuppysite.com/wp-content/uploads/2017/12/puppy9.jpg",
            description = "",
        ),
        Puppy(
            id = 3,
            name = "Leonardo",
            breed = "Husky",
            age = "5 months",
            imageURL = "https://st.depositphotos.com/2588973/2940/i/950/depositphotos_29401593-stock-photo-close-up-of-husky-puppy.jpg",
            description = "",
        ),
        Puppy(
            id = 4,
            name = "Maya",
            breed = "Corgi",
            age = "3 months",
            imageURL = "https://theawesomedaily.com/wp-content/uploads/2017/04/corgi-puppies-3a-1.jpg",
            description = "",
        ),
        Puppy(
            id = 5,
            name = "Alice",
            breed = "Pom",
            age = "3 months",
            imageURL = "https://i1.wp.com/readysetpuppy.com/wp-content/uploads/2019/10/Bringing-home-a-Pomeranian.jpg?fit=999%2C613&ssl=1",
            description = "",
        ),
        Puppy(
            id = 6,
            name = "Harry",
            breed = "Bulldog",
            age = "2 months",
            imageURL = "https://i.pinimg.com/originals/67/4c/fe/674cfe9396a93664cfef2d291571736a.jpg",
            description = "",
        ),
    )

    /**
     * Returns a puppy for the given id.
     */
    fun getPuppyById(id: Int) =
        LIST.find { it.id == id }
}