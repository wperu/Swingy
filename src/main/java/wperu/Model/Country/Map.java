package wperu.Model.Country;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

public class Map {

    @Min(9)
    protected int size;
    @Min(1)
    protected int level;

    @NotNull
    @Valid
    protected int[][] map;
    

}
