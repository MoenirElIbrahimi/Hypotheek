//package nl.rocnijmegen;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.*;
//
//public class AppTest {
//
//    private InputVerwerking mockInputVerwerking;
//    private HypotheekService mockHypotheekService;
//    private PostcodeChecker mockPostcodeChecker;
//
//    @BeforeEach
//    public void setUp() {
//        mockInputVerwerking = Mockito.mock(InputVerwerking.class);
//        mockHypotheekService = Mockito.mock(HypotheekService.class);
//        mockPostcodeChecker = Mockito.mock(PostcodeChecker.class);
//    }
//
//    @Test
//    public void testMainWithValidPostcodeAndInputs() {
//        // Stel de verwachte waarden in
//        when(mockPostcodeChecker.postcode()).thenReturn(1234); // geldige postcode
//        when(mockInputVerwerking.vraagInkomen("uzelf")).thenReturn(3000.0); // inkomen
//        when(mockInputVerwerking.vraagHeeftPartner()).thenReturn(true);
//        when(mockInputVerwerking.vraagInkomen("uw partner")).thenReturn(2000.0); // partner inkomen
//        when(mockInputVerwerking.vraagHeeftStudieschuld()).thenReturn(false);
//        when(mockInputVerwerking.vraagRentevastePeriode()).thenReturn(30); // rentevaste periode
//
//        double verwachteMaximaleHypotheek = 214500.0; // Verwachte output voor maximale hypotheek
//        when(mockHypotheekService.berekenMaximaleHypotheek(3000.0, 2000.0, false, 30)).thenReturn(verwachteMaximaleHypotheek);
//        when(mockHypotheekService.berekenRentePerMaand(verwachteMaximaleHypotheek, 30)).thenReturn(893.75); // voorbeeld rente
//        when(mockHypotheekService.berekenAflossingPerMaand(verwachteMaximaleHypotheek, 30)).thenReturn(596.25); // voorbeeld aflossing
//        when(mockHypotheekService.berekenTotaalBetaald(1490.0, 30)).thenReturn(535200.0); // totaal betaald
//
//        // Voer de main methode uit (je kunt de main-methode aanpassen om mockobjecten te accepteren)
//        // Dit kan vereisen dat je de main-methode aanpast zodat deze niet rechtstreeks instantiaties maakt
//        App.main(new String[]{}); // Deze aanroep kan verschillen afhankelijk van je implementatie
//
//        // Verifieer dat de methoden zijn aangeroepen
//        verify(mockPostcodeChecker).postcode();
//        verify(mockInputVerwerking).vraagInkomen("uzelf");
//        verify(mockInputVerwerking).vraagHeeftPartner();
//        verify(mockInputVerwerking).vraagInkomen("uw partner");
//        verify(mockInputVerwerking).vraagHeeftStudieschuld();
//        verify(mockInputVerwerking).vraagRentevastePeriode();
//        verify(mockHypotheekService).berekenMaximaleHypotheek(3000.0, 2000.0, false, 30);
//        verify(mockHypotheekService).berekenRentePerMaand(verwachteMaximaleHypotheek, 30);
//        verify(mockHypotheekService).berekenAflossingPerMaand(verwachteMaximaleHypotheek, 30);
//        verify(mockHypotheekService).berekenTotaalBetaald(1490.0, 30);
//    }
//
//    @Test
//    public void testMainWithInvalidPostcode() {
//        // Stel de verwachte waarden in
//        when(mockPostcodeChecker.postcode()).thenReturn(-1); // Ongeldige postcode
//
//        // Voer de main methode uit
//        App.main(new String[]{}); // Deze aanroep kan verschillen afhankelijk van je implementatie
//
//        // Verifieer dat de postcodecheck is uitgevoerd en dat de applicatie is gestopt
//        verify(mockPostcodeChecker).postcode();
//    }
//
//    // Hier kun je meer tests toevoegen om verschillende scenario's te testen
//}
