(* Fonction pour la stack *)

let empty_stack = [];;

let push a stack = a::stack;;

let peek stack = match stack with
    | [] -> failwith "error : empty stack"
    | a::r -> a;;

let is_empty stack = stack = empty_stack;;

let pop stack = match stack with
    | [] -> failwith "error : empty stack"
    | _::r -> r;;


(*------------------------------*)

type opes = Value of int | MULT | NO_OP;;


let explode s =
  let rec exp i l =
    if i < 0 
    then l 
    else exp (i - 1) (s.[i] :: l) 
  in exp (String.length s - 1) [];;


let char_to_int  a = Char.code a - 48;; 


let rec compile expr = match expr with 
    | [] -> []
    | a::r  when (a >= '0' && a <= '9') -> Value (char_to_int a) :: compile r
    | a::r when a = '*' -> MULT :: compile r
    | _::r -> NO_OP :: compile r;;

let interprete expr = 
    let rec aux read to_read = match read, to_read with
        | read, [] -> read
        | read, NO_OP::r -> aux read r
        | read, Value(a)::r -> aux (a :: read) r        
        | a::b::xs, MULT::r -> aux ((a*b)::xs) r
        | _, _ -> failwith "error"
    in aux [] expr;;




