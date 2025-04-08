# WCIF
This is a feature complete Java implementation of the [WCIF](https://github.com/thewca/wcif) specification, aiming to be bug-for-bug compatible with the real world implementation in [worldcubeassociation.org](https://www.worldcubeassociation.org).

# Usage
Several examples can be found in the `src/examples` directory. The main thing to note is that the use of `JavaTimeModule` in Jackson is required for timestamp (de)serialization.