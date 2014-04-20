pf2013 Ejem2

decl

intset a, b, c, d;

int numElem, elem, i;

begin
a:= {0, 1, 3, 5, 7, 9};
b:= {0, 2, 4, 6, 8};
c:= a union b;
d:= a intersec b;
print("Cardinal de a= " + int2str(card(a)));
print("Cardinal de b= " + int2str(card(b)));
print("Cardinal de c= " + int2str(card(c)));
print("Cardinal de \"d\"= " + int2str(card(d)));

numElem:=card(c);
i:=0;

while card(c)>0 and i>-1 do 
  elem:= lowest_elem(c);
  print("Elemento " + int2str(i) + "= " + int2str(elem));
  i:=i + 1;
  numElem:=numElem - 1;
  c:= c - { elem };
  if not (numElem=card(c))
  then
    i:=-1;
  end;
end;

end;
