package ru.naimix.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TarotCard {
    // Старшие Арканы
    THE_FOOL(0, "The Fool", "Новое начало, невинность, спонтанность, свобода духа"),
    THE_MAGICIAN(1, "The Magician", "Манифестация, находчивость, сила и действия"),
    THE_HIGH_PRIESTESS(2, "The High Priestess", "Интуиция, подсознание, тайна"),
    THE_EMPRESS(3, "The Empress", "Забота, изобилие, материнское влияние"),
    THE_EMPEROR(4, "The Emperor", "Власть, структура, контроль, отцовство"),
    THE_HIEROPHANT(5, "The Hierophant", "Традиции, духовность, соответствие"),
    THE_LOVERS(6, "The Lovers", "Любовь, союз, выборы, партнерства"),
    THE_CHARIOT(7, "The Chariot", "Победа, сила воли, контроль, решимость"),
    STRENGTH(8, "Strength", "Мужество, храбрость, внутренняя сила, уверенность"),
    THE_HERMIT(9, "The Hermit", "Одиночество, внутренняя рефлексия, мудрость"),
    WHEEL_OF_FORTUNE(10, "Wheel of Fortune", "Удача, циклы, судьба, предназначение"),
    JUSTICE(11, "Justice", "Справедливость, истина, закон, баланс"),
    THE_HANGED_MAN(12, "The Hanged Man", "Жертва, освобождение, отпускание, новые перспективы"),
    DEATH(13, "Death", "Трансформация, завершения, возрождение, переход"),
    TEMPERANCE(14, "Temperance", "Баланс, умеренность, терпение"),
    THE_DEVIL(15, "The Devil", "Искушение, материализм, зависимость, оковы"),
    THE_TOWER(16, "The Tower", "Внезапные изменения, потрясения, хаос, разрушение"),
    THE_STAR(17, "The Star", "Надежда, вдохновение, мир, исцеление"),
    THE_MOON(18, "The Moon", "Иллюзия, интуиция, сны, подсознание"),
    THE_SUN(19, "The Sun", "Радость, жизненная сила, успех, ясность"),
    JUDGEMENT(20, "Judgement", "Рефлексия, суд, пробуждение, возрождение"),
    THE_WORLD(21, "The World", "Завершение, достижение, исполнение");
    private final int id;
    private final String name;
    private final String description;
}
