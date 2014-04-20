pf2013 Ejem6

decl

intset a, b, c, d, e;

int i, sig;

begin
a:= {0, 1, 3, 5, -2, 7, 9, 4};
b:= {0, -2, 4, -6, 8, 10};
c:= a union b;
d:= a intersec b;
e:= a - b;
print("Cardinal de a= " + int2str(card(a)));
print("Cardinal de b= " + int2str(card(b)));
print("Cardinal de c= " + int2str(card(c)));
print("Cardinal de d= " + int2str(card(d)));
print("Cardinal de e= " + int2str(card(e)));

i:=0;

while not (e = emptyset) do
  sig:=lowest_elem(e);
  print("Elemento " + int2str(i) + " de e = " + int2str(sig));
  i:= i + 1;
  e:= e - {sig};
end;

end;
