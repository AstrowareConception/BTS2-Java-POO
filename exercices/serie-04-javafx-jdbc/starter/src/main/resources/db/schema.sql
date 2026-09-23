PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS genre (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS movie (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    release_year INTEGER NOT NULL CHECK (release_year >= 1888),
    duration INTEGER NOT NULL CHECK (duration BETWEEN 1 AND 600),
    genre_id INTEGER NOT NULL REFERENCES genre(id),
    archived INTEGER NOT NULL DEFAULT 0 CHECK (archived IN (0, 1)),
    UNIQUE(title, release_year)
);

CREATE INDEX IF NOT EXISTS idx_movie_title ON movie(title);
