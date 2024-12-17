# <h1>ChessMalupet? </h1>


A 40% of the chess engine done using mostly the basics of java andmy iconic coding style that hasn't change since the last summer.
this application takes a chess notation e.g (Nb2 - Nc3) as an input and evaluates the move, performing actions and simulating a chess game via terminal. it Prints out the board and checks all valid piece moves and captures. All possible moves and captures are stored within a list an is appended when a piece is called. evaluating the piece leads to appending All the valid combinations that a piece can do and returned as a chess notation. This can be used to be implemented in a gui via tiles system and also can be used in data analytics such as game analysis and game status.

-----

**The (raw)tought process on the concepts**
this is so that you can easily identify and use the returned values to make your data evaluation (if used for game analysis) easily.

1. move evaluator<br>
    1.1 Determine color:
    - check if selected piece to move is the same color as your piece by
        - using if odd/even to determine kung anong kulay na ang titira
        - then getting the value dun sa board array, check charAt(0) : since may label yun kung B or W, thats it.<br>
   1.2 IsOccupied?
    - check if the 2nd notation e.g “next_move” variable is in ALL_POSSIBLE_MOVES array to be returned by pieces class.
        - we can map out the pos_in_array_column and pos_in_array_row , then create calculations based of that.
        - if may value yung array dun na hindi “0”, then bawal yung move nayun<br>
   1.3 IsAValidCapture?
    - Check if capture move is valid by checking if the move_method is capture or not
        - call padin natin all possible moves, get the array of all the possible moves na pwedeng gawin ng isang piece pero instead na              “0” yung value sa array_row and array_column, wag mo ireturn yung postition nun kung “0”  or same color yung piece mo (kasi                 bawal icapture ang same colored piece malamang)<br>
   1.4 King's Radar (not yet implemented medyo tricky)
    - after that all possible king check method(), eto medyo malala pero simpleng loop lang din sya na nagrereturn ng all possible moves         via horizontal, vertical, and diagonal + check if the knight squares does have a opposite colored knight.
    - paano to gagawin? yun, scan through the array, but pag may nadetect na ang value sa array_row and array_column is  same colored             piece, then the hemisphere nung check is wala na. e.g kung ma nakaharang na pawn or any piece sa rank/file na yun, wala na
    - pero pag may bishop,queen,pawn - diagonal, rook,queen- rank/file and knight - specified +1x||1y && 3x||3y then ayun, return a             boolean variable.

-----

<h2> How the 4 Fundamentals of OOP was implimented </h2>

I was able to implement the core fundamentals of OOP by using<br><br>
        1. Inheritance (extends) where best prime example ko dito eh the pieces itself, each of them inheriting the methods from [piece.Java](http://piece.Java) get_all moves and captures combinations and also inheriting the game_array from the main game.<br><br>
    2. Polymorphism (using the same move set but different implementation/logic form e.g rook and queen and king) As I have reused move sets to make prodcution be fast as possible with only changing minor variables in the code flow for the reused move set implemented to a similar piece behaviour like a queen to a king.<br><br>
    3. Abstraction (where I converge everything unto a class that hides details e.g start game) I was not able to use an abstract class simply because I cannot instantiate it, and need din dapat lahat ng methods nung parent class meron si child class, although that is applicable sa [pieces.Java](http://pieces.Java) ko, there are unique methods that only a king can have, sa next feature ko sa determining all possible check tiles ganun, and all castling which is not implemented pa<br><br>
    4. Encapsulation (where you can only access/modify data using private modifer and protected) giving the data only be accessed by a class with permission, syempre the list of all possible combinations can only be accessed by the pieces itself. e.g rook, king queen where there are there only ones who can append to those lists.

-----

<h2>Remarks</h2>
-So far sa run ko na to, this is what I could have come up with. sorry for being late but nagenjoy ako sa subject na to.<br>
-I was doing a different project then decided to change it at the end of Nov, so from scratch ulit so yeahhhh.<br>
-you can run the code as vanila java. thats all. hope this becomes useful to you.


