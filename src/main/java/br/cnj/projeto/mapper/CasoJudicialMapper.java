package br.cnj.projeto.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.cnj.projeto.dto.CasoJudicialDTO;
import br.cnj.projeto.models.CasoJudicial;

public interface CasoJudicialMapper {
    CasoJudicialMapper INSTANCE = Mappers.getMapper(CasoJudicialMapper.class);

    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "descricao", target = "descricao")
    CasoJudicialDTO casoJudicialToDTO(CasoJudicial casoJudicial);

    @Mapping(source = "numero", target = "numero")
    @Mapping(source = "descricao", target = "descricao")
    CasoJudicial dtoToCasoJudicial(CasoJudicialDTO casoJudicialDTO);
}
