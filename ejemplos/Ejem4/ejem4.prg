pf2013 Ejem4

decl

intset a, b, c, d, e;

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

i:=0;

e:= { };

while (i<100) do
  e:= e union {2 * i + 1};
  if (i > 80) or ((i/4)*4=i)
  then e:=e union {i};
  end;
  i:= i + 1;
end;

i:=0;

e:= e union b;

while card(e)>0 do 
  elem:= lowest_elem(e);
  print("Elemento " + int2str(i) + "= " + int2str(elem));
  i:=i + 1;
  e:= e - { elem };
end;

end;
