clc
close all
clear all

%note=['ccggaag ffeeddc ggffeed ggffeed ccggaag ffeeddc']; %Twinkle Twinkle Litte Star
note=['ccdcfe ccdcgf cccafed bbafgf']; %Happy Birthday

f=0;

for i=1:length(note)
	if(note(i)=='c')
		disp(note(i))
		f=261;
		tone(f);
	elseif (note(i)=='d')
	disp(note(i))
		f=294;
		tone(f);
	elseif (note(i)=='e')
	disp(note(i))
		f=329;
		tone(f);
	elseif (note(i)=='f')
	disp(note(i))
		f=349;
		tone(f);
	elseif (note(i)=='g')
	disp(note(i))
		f=392;
		tone(f);
	elseif (note(i)=='a')
	disp(note(i))
		f=440;
		tone(f);
	elseif (note(i)=='b')
	disp(note(i))
		f=493;
		tone(f);
	else
	disp('space')
		f=0;
		tone(f);
        
	end
end


