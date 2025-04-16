import { View, Text, StyleSheet, ScrollView, Image, TouchableOpacity } from 'react-native';
import { MapPin, Phone, Clock } from 'lucide-react-native';

const LOCATIONS = [
  {
    id: '1',
    name: 'Downtown Store',
    address: '123 Main Street, Downtown',
    phone: '(555) 123-4567',
    hours: '10:00 AM - 10:00 PM',
    image: 'https://images.unsplash.com/photo-1562967916-eb82221dfb92?w=500&h=300&fit=crop',
  },
  {
    id: '2',
    name: 'Mall Location',
    address: 'Central Mall, 2nd Floor',
    phone: '(555) 987-6543',
    hours: '11:00 AM - 9:00 PM',
    image: 'https://images.unsplash.com/photo-1559329007-40df8a9345d8?w=500&h=300&fit=crop',
  },
  {
    id: '3',
    name: 'Beach Store',
    address: '789 Beach Boulevard',
    phone: '(555) 456-7890',
    hours: '12:00 PM - 11:00 PM',
    image: 'https://images.unsplash.com/photo-1556742393-d75f468bfcb0?w=500&h=300&fit=crop',
  },
];

export default function LocationsScreen() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerTitle}>Our Locations</Text>
      </View>

      <View style={styles.locationsContainer}>
        {LOCATIONS.map((location) => (
          <TouchableOpacity key={location.id} style={styles.locationCard}>
            <Image source={{ uri: location.image }} style={styles.locationImage} />
            <View style={styles.locationContent}>
              <Text style={styles.locationName}>{location.name}</Text>
              
              <View style={styles.infoRow}>
                <MapPin size={16} color="#666" />
                <Text style={styles.infoText}>{location.address}</Text>
              </View>
              
              <View style={styles.infoRow}>
                <Phone size={16} color="#666" />
                <Text style={styles.infoText}>{location.phone}</Text>
              </View>
              
              <View style={styles.infoRow}>
                <Clock size={16} color="#666" />
                <Text style={styles.infoText}>{location.hours}</Text>
              </View>
            </View>
          </TouchableOpacity>
        ))}
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  header: {
    backgroundColor: '#FF1493',
    padding: 20,
    paddingTop: 60,
    paddingBottom: 20,
  },
  headerTitle: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#fff',
    textAlign: 'center',
  },
  locationsContainer: {
    padding: 20,
  },
  locationCard: {
    backgroundColor: '#fff',
    borderRadius: 12,
    marginBottom: 20,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 3,
    overflow: 'hidden',
  },
  locationImage: {
    width: '100%',
    height: 150,
  },
  locationContent: {
    padding: 15,
  },
  locationName: {
    fontSize: 20,
    fontWeight: 'bold',
    color: '#333',
    marginBottom: 10,
  },
  infoRow: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 8,
  },
  infoText: {
    fontSize: 14,
    color: '#666',
    marginLeft: 8,
  },
});