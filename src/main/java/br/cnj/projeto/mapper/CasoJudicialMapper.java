package br.cnj.projeto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.cnj.projeto.dto.CasoJudicialDTO;
import br.cnj.projeto.models.CasoJudicial;

@Mapper
public interface CasoJudicialMapper {
    CasoJudicialMapper INSTANCE = Mappers.getMapper(CasoJudicialMapper.class);

    CasoJudicialDTO casoJudicialToDTO(CasoJudicial casoJudicial);

    @Mapping(target = "id", ignore = true)
    CasoJudicial dtoToCasoJudicial(CasoJudicialDTO casoJudicialDTO);

    List<CasoJudicialDTO> listCasosJudiciaisDTO(List<CasoJudicial> listCasosJudiciais);
}
