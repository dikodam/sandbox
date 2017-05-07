package de.dikodam.sandbox.java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dataprocessor {
    Dataholder dataholder;

    public Dataprocessor(Dataholder dataholder) {
        this.dataholder = dataholder;
    }

    @SuppressWarnings("unchecked")
    public <T extends DatenDto> List<T> getDtos(Class<T> dtoTyp) {
        List<Class<?>> dtoTypImplementedInterfaces = Arrays.asList(dtoTyp.getInterfaces());

        if (dtoTypImplementedInterfaces.contains(ProzessDatenDto.class)) {
            List<T> typElemente = new ArrayList<>();
            List<ProzessDatenDto> prozessDatenDtos = dataholder.getProzessDatenDtos();
            for (ProzessDatenDto dto : prozessDatenDtos) {
                if (dto.getClass() == dtoTyp) {
                    typElemente.add((T) dto);
                }
            }
            return typElemente;
        }
        if (dtoTypImplementedInterfaces.contains(PersonenDatenDto.class)) {
            return dataholder.getPersonenDatenDtos().stream()
                    .filter(dto -> dto.getClass() == dtoTyp)
                    .map(dto -> (T)dto)
                    .collect(Collectors.toList());
        }
        if (dtoTypImplementedInterfaces.contains(FachlicheDatenDto.class)) {
            return dataholder.getFachlicheDatenDtos().stream()
                    .filter(dto -> dto.getClass() == dtoTyp)
                    .map(dto -> (T)dto)
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Übergebener Typ kein Untertyp von ProzessDatenDto, PersonenDatenDto oder FachlicheDatenDto!");
    }

}
