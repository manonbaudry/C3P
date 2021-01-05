(* Exercice 1. Une simple liste d’entiers *)

let rec integers n =
if n = 0 then [n]
else (integers (n-1) ) @ [n];;

let rec intt n = match n with 
    | 0 -> []
    | n -> n :: (intt (n-1));;

let inttt n = List.rev (intt n);;

let inttt n = 
    let rec aux n = match n with 
    | 0 -> [0]
    | n -> n :: (aux (n-1))
    in List.rev (aux n);;

let integers2 n =
    let rec aux cpt n = match cpt with
    | cpt when cpt = (n+1) -> []
    | cpt  -> cpt :: (aux (cpt+1) n)
    in aux 0;;

(* Exercice 2. Traiter des listes de nombres *)

let size l =
    let rec size_aux l acc = match l with
    | [] -> acc
    | a::r -> size_aux r (acc+1)
in size_aux l 0;;

let three_or_more l = if size l >= 3 then true else false;; 

let last l = match l with
    | [] -> failwith "error"
    | l -> List.hd(List.rev l);;

let sum l = 
    let rec aux s l = match l with
        | [] -> s
        | hd::tl -> aux (s + hd) tl
    in aux 0 l;;

let rec find e l =  match l with
        | [] -> false
        | hd::tl when hd = e -> true
        | hd::tl -> find' e tl;;

let rec nth n l = match l with
    | [] -> failwith "error"
    | hd::tl when n = 0 -> hd
    | hd::tl -> nth (n-1) tl;;

let is_increasing l = 
    let rec aux prev l = match l with
        | [] -> true
        | hd::tl when prev > hd -> false 
        | hd::tl -> aux hd tl
    in aux (List.hd l) l;;  


    (*Exercice 3. Créer des listes de nombres*)

let list_copy l = 
    let rec aux l copy = match l with
        | [] -> copy
        | hd::tl -> aux tl (copy @ [hd])
    in aux l [];;

let reverse l = List.rev(list_copy l)