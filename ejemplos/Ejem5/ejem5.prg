pf2013 Ejem5

decl

intset a, b, c, d, e;

int numElem, elem, i;

begin
a:= {0, 1, 3, 5, 7, 9};
b:= {0, -2, 4, -6, 82};
c:= a union b;
d:= a intersec b;
print("Cardinal de a= " + int2str(card(a)));
print("Cardinal de b= " + int2str(card(b)));
print("Cardinal de c= " + int2str(card(c)));
print("Cardinal de \"d\"= " + int2str(card(d)));

i:=0;

e:= emptyset;

while (i<100) do
  e:= e union {2 * i + 1};
  i:=i + 1;
end;

i:=-10;

e:= e union b;

while (i<250) do 
  if i in e
  then 
    print(int2str(i) + " es elemento de e");
   end;
   i:=i + 1;
end;

end;
