(* Exercice 1. Prise en main de l’interpréteur *)

(* Question 3 *)
(* 2 -> int
   2.0 -> float
   2,0 -> int * int = (2, 0)
   2;0 -> erreur
   a -> erreur
   ’a’ -> char 
   "a" -> string
   true -> bool
   () -> unit (tuple)
   [] -> list
   [1] int list
   [1, true] -> (int * bool) list
   [1;true] -> Error: This expression has type bool but an expression was expected of type int
*)

(* Question 4 *)
(* 
int * float -> (1,1.)
(int, float) -> (1,1.)
string list -> ["hello"]
bool list * string -> [true],"hello"
’a * int -> impossible à cause de 'a
*)

(* Question 5 *)



(* Exercice 2. Conditions *)

(*1*)
let max a b = if a > b then a else b;;
max 1 2;;

(*2*)
let min a b = if a > b then b else a;;
min 4 (min 2 3);;

(*3*)
let pair a = if a mod 2 = 0 then string_of_int a else "odd";;
pair 2;;
- : string = "2"
pair 5;;
- : string = "odd"

(*4*)
(*La syntaxe est incorrecte, on ne peut pas affecter 2 fois une valeur à b dans une même fonction*)

(*5*)
let b a = if a<10 then "small" else "large";;


(* Exercice 3. Premières fonctions *)
(*1*)
let average a b c = (a + b + c)/3;;
(*Elle ne peut pas être utilisée avec des flottant car elle prend des entiers en paramètre 
val average : int -> int -> int -> int = <fun> *)

(*2*)
let implies a b = if (a = true) && b = false then false else true;;

(*3*)
fst : 'a * 'b -> 'a = <fun>
snd : 'a * 'b -> 'b = <fun>

(*4*)
(* fst renvoi le premier élèment du tuple 
   snd renvoi le deuxième élèment du tuple *)

(* 5*)
let inv a = (snd a, fst a);;
let inv (a, b) =  (b, a);;
let inv a =  match a with
| (x,y) -> (y,x);;


(* Exercice 4. La suite de Fibonacci *)

let rec fib n =  match n  with
| 0 -> 0
| 1 -> 1
| n -> fib (n-2) + fib (n-1);;


(* Exercice 5. Plus grand diviseur commun *)
let rec pgcd m n =  match m  with
| 0 -> n
| m when m > n -> pgcd n m 
| _ -> pgcd (n mod m) m;;


(* Exercice 6. Fonctions mutuellement récursives *)
let rec pair n = if n = 0 then true else impair (n-1) 
and impair n = if n = 0 then false else pair (n-1);;

(* Exercice 7. Récursivité terminale 1/2 *)
let fact n =
    let rec inner x n =
        if n = 0 then 
            x
        else
            inner (n * x) (n - 1)
    in
        inner 1 n;;

(* Exercice 8. Récursivité terminale 2/2 *)

let fib2 current =  
    let rec inner idx prev current = match current  with
        | 0 -> 0
        | 1 -> 1
        | current -> inner (idx - 1) (prev + current) prev
    in inner current (current - 1) current ;;   