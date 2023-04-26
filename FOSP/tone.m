function tone(f)
	fs=44100;

	t=linspace(0,2*pi, 44100*2);
	y=sin(2*f*t);
	disp(f)
    sound(y*100,fs)
    pause(0.3)
    clear sound
    
end



