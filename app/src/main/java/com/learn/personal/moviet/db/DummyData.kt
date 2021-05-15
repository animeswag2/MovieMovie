package com.learn.personal.moviet.db

import com.learn.personal.moviet.R
import com.learn.personal.moviet.models.Film
import com.learn.personal.moviet.ui.adapters.FilmAdapter

object DummyData {
    fun generateDummyMovies(): ArrayList<Film> {
        val movies = ArrayList<Film>()

        movies.add(Film(
                "MOV01",
                "A Star Is Born",
                "It stars Cooper, Lady Gaga, Dave Chappelle, Andrew Dice Clay, and Sam Elliott, and follows a hard-drinking musician (Cooper) who discovers and falls in love with a young singer (Gaga). It is the fourth filmed version of the 1937 film, after the 1954 musical and the 1976 musical.",
                "120 m",
                R.drawable.poster_a_star_is_born
        ))

        movies.add(Film(
                "MOV02",
                "Alita Batle Angel",
                "Alita: Battle Angel is a 2019 American cyberpunk action film based on Japanese manga artist Yukito Kishiro's 1990s series Battle Angel Alita and its 1993 original video animation adaptation, Battle Angel. It was directed by Robert Rodriguez, produced by James Cameron and written by Cameron and Laeta Kalogridis.",
                "210 m",
                R.drawable.poster_alita
        ))

        movies.add(Film(
                "MOV03",
                "Aquaman",
                "Aquaman is a 2018 American superhero film based on the DC Comics character of the same name. Distributed by Warner Bros. Pictures, it is the sixth film in the DC Extended Universe (DCEU). The film was directed by James Wan, from a screenplay by David Leslie Johnson-McGoldrick and Will Beall.",
                "180 m",
                R.drawable.poster_aquaman,
        ))

        movies.add(Film(
                "MOV04",
                "Bohemian Rhapsody",
                "Bohemian Rhapsody is a 2018 biographical drama film directed by Bryan Singer from a screenplay by Anthony McCarten, and produced by Graham King and Queen manager Jim Beach. The film tells the story of Freddie Mercury, the lead singer of the British rock musical band Queen.",
                "130 m",
                R.drawable.poster_bohemian,
        ))

        movies.add(Film(
                "MOV05",
                "Cold Pursuit",
                "Cold Pursuit is a 2019 action thriller film directed by Hans Petter Moland from a screenplay by Frank Baldwin. A British-American co-production, the film stars Liam Neeson, Tom Bateman, Tom Jackson, Emmy Rossum, Domenick Lombardozzi, Julia Jones, John Doman, and Laura Dern.",
                "140 m",
                R.drawable.poster_cold_persuit,
        ))

        movies.add(Film(
                "MOV06",
                "Creed",
                "Creed is a 2015 American sports drama film directed by Ryan Coogler from a story by Coogler and a screenplay written by Coogler, Aaron Covington, and Sylvester Stallone who wrote all the scenes and dialogues with his character in the film.",
                "150 m",
                R.drawable.poster_creed,
        ))

        movies.add(Film(
                "MOV07",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Fantastic Beasts: The Crimes of Grindelwald is a 2018 fantasy film directed by David Yates and written by J. K. Rowling. A joint American and British production, it is the sequel to Fantastic Beasts and Where to Find Them (2016).",
                "145 m",
                R.drawable.poster_crimes,
        ))

        movies.add(Film(
                "MOV08",
                "Glass",
                "Glass is a 2019 American psychological superhero thriller film written and directed by M. Night Shyamalan, who also produced with Jason Blum, Marc Bienstock, and Ashwin Rajan. It was co-produced by John Rusk, who was also the 1st assistant director on this film as well as on many other Shyamalan's films.",
                "155m",
                R.drawable.poster_glass,
        ))

        movies.add(Film(
                "MOV09",
                "How to train your dragon",
                "How to Train Your Dragon: The Hidden World was released on January 3, 2019, in Australia, and on February 22 in the United States. The film marks the first DreamWorks Animation film to be distributed by Universal Pictures.",
                "166m",
                R.drawable.poster_how_to_train,
        ))

        movies.add(Film(
                "MOV10",
                "Avengers: Infinity Wars",
                "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.",
                "142m",
                R.drawable.poster_infinity_war
        ))
        return movies
    }

    fun generateDummyTvShows(): ArrayList<Film> {
        val tvShows = ArrayList<Film>()

        tvShows.add(Film(
                "TV01",
                "Arrow",
                "Arrow is an American superhero television series developed by Greg Berlanti, Marc Guggenheim, and Andrew Kreisberg based on the DC Comics character Green Arrow, a costumed crime-fighter created by Mort Weisinger and George Papp, and is set in the Arrowverse with other related television series.",
                "24 episodes",
                R.drawable.poster_arrow
        ))

        tvShows.add(Film(
                "TV02",
                "Doom Patrol",
                "Doom Patrol is a superhero team from DC Comics. The original Doom Patrol first appeared in My Greatest Adventure #80 (June 1963), and was created by writers Arnold Drake and Bob Haney, and artist Bruno Premiani. Doom Patrol has appeared in different incarnations in multiple comics, and have been adapted to other media.",
                "23 episodes",
                R.drawable.poster_doom_patrol
        ))

        tvShows.add(Film(
                "TV03",
                "Dragon Ball",
                "Dragon Ball tells the tale of a young warrior by the name of Son Goku, a young peculiar boy with a tail who embarks on a quest to become stronger and learns of the Dragon Balls, when, once all 7 are gathered, grant any wish of choice.",
                "25 episodes",
                R.drawable.poster_dragon_ball
        ))

        tvShows.add(Film(
                "TV04",
                "Fairy Tail",
                "The story is about Lucy, an aspiring Celestial Wizard, becomes a friend and ally to powerful wizards Natsu, Gray, and Erza, who are part of the (in)famous wizard guild, Fairy Tail.",
                "24 episodes",
                R.drawable.poster_fairytail
        ))

        tvShows.add(Film(
                "TV05",
                "Family Guy",
                "Family Guy is an American animated sitcom created by Seth MacFarlane for the Fox Broadcasting Company that premiered on January 31, 1999. The series is produced by Fuzzy Door Productions.",
                "24 episodes",
                R.drawable.poster_family_guy
        ))

        tvShows.add(Film(
                "TV06",
                "Flash",
                "The Flash is an American superhero television series developed by Greg Berlanti, Andrew Kreisberg, and Geoff Johns, airing on The CW. It is based on the Barry Allen incarnation of DC Comics character the Flash, a costumed superhero crime-fighter with the power to move at superhuman speeds.",
                "24 episodes",
                R.drawable.poster_flash
        ))

        tvShows.add(Film(
                "TV07",
                "Game of Thrones",
                "Game of Thrones is an American fantasy drama television series created by David Benioff and D. B. Weiss for HBO. It is an adaptation of A Song of Ice and Fire, a series of fantasy novels by George R. R. Martin, the first of which is A Game of Thrones.",
                "24 episodes",
                R.drawable.poster_god
        ))

        tvShows.add(Film(
                "TV08",
                "Gotham",
                "Gotham was an American action crime drama television series developed by Bruno Heller, produced by Warner Bros. Television and based on characters published by DC Comics and appearing in the Batman franchise, primarily those of James Gordon and Bruce Wayne. The series premiered on Fox on September 22, 2014, and concluded on April 25, 2019.",
                "24 episodes",
                R.drawable.poster_gotham
        ))

        tvShows.add(Film(
                "TV09",
                "Greys Anatomy",
                "Grey's Anatomy is an American medical drama television series that premiered on March 27, 2005, on the American Broadcasting Company (ABC) as a mid-season replacement. The fictional series focuses on the lives of surgical interns, residents, and attendings as they develop into seasoned doctors while balancing personal and professional relationships.",
                "24 episodes",
                R.drawable.poster_grey_anatomy
        ))

        tvShows.add(Film(
                "TV10",
                "Hanna",
                "Hanna is an American action drama streaming television series, based on the 2011 film of the same name, for Prime Video. The series was created and written by David Farr, directed by Sarah Adina Smith, and stars Esme Creed-Miles and Mireille Enos.",
                "24 episodes",
                R.drawable.poster_hanna
        ))

        return tvShows
    }
}